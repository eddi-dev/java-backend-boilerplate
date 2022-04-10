docker rm -f nginx-local-moim
docker rmi -f nginx-local-moim
docker network create -d bridge local-moim-network
docker build -t nginx-local-moim .
docker run --name nginx-local-moim -d --network=local-moim-network -p 80:80 nginx-local-moim