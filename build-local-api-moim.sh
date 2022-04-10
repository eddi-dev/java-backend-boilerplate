./gradlew clean build
docker rm -f api-local-moim
docker rmi -f api-local-moim
docker network create -d bridge local-moim-network
docker build -t api-local-moim .
docker run --name api-local-moim -d --network=local-moim-network -p 8080:8080 api-local-moim