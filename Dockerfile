FROM nginx:latest
EXPOSE 80/tcp
EXPOSE 443/tcp
COPY src/main /usr/share/nginx/html
COPY src/main/nginx /etc/nginx
