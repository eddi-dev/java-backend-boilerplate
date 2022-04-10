FROM nginx:latest

COPY conf/nginx.conf /etc/nginx/conf.d/nginx.conf
RUN apt-get update && apt-get install -y iputils-ping wget vim

CMD ["nginx", "-g", "daemon off;"]

EXPOSE 80