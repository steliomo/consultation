FROM mysql:5.6

LABEL maintainer="steliomo@gmail.com"

ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=consultation
ENV MYSQL_USER=consultation
ENV MYSQL_PASSWORD=consultation
ENV MYSQL_DATA_DIRECTORY=/opt/data/system/mysql

ADD mysql.cnf /root/.my.cnf
ADD localtime /etc/localtime

COPY run.sh /run.sh

VOLUME /opt/consultation/data

EXPOSE 3306

CMD ["/run.sh"]