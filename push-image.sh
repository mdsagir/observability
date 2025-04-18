#!/bin/bash

# Set image details
IMAGE_NAME="sagiransari/demo"
IMAGE_TAG="0.0.1-SNAPSHOT"
FULL_IMAGE="$IMAGE_NAME:$IMAGE_TAG"

# Check if image already exists
if docker images | grep -q "$IMAGE_NAME" | grep -q "$IMAGE_TAG"; then
  echo "🗑 Removing existing image: $FULL_IMAGE"
  docker rmi -f $FULL_IMAGE
fi
# Remove dangling images for the same repo
DANGLING_IDS=$(docker images "$IMAGE_NAME" --filter "dangling=true" -q)
if [ -n "$DANGLING_IDS" ]; then
  echo "🗑 Removing dangling images for $IMAGE_NAME"
  docker rmi -f $DANGLING_IDS
fi
dangling_images=$(docker images -f "dangling=true" -q)
if [ -n "$dangling_images" ]; then
  docker rmi -f $dangling_images
else
  echo "No dangling images found."
fi


echo "🔨 Building Docker image using bootBuildImage..."
./gradlew bootBuildImage --imageName=$FULL_IMAGE

if [ $? -ne 0 ]; then
  echo "❌ Image build failed. Exiting."
  exit 1
fi

echo "🔐 Logging in to Docker Hub..."
docker login
if [ $? -ne 0 ]; then
  echo "❌ Docker login failed. Exiting."
  exit 1
fi

echo "📤 Pushing image to Docker Hub: $FULL_IMAGE"
docker push $FULL_IMAGE

if [ $? -eq 0 ]; then
  echo "✅ Image pushed successfully!"
else
  echo "❌ Failed to push image."
fi