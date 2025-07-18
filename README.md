```bash

docker run -d --rm -p 3306:3306 -e MYSQL_ROOT_PASSWORD=senhaRoot -e MYSQL_DATABASE=bcd -e MYSQL_USER=aluno -e MYSQL_PASSWORD=aluno -e MYSQL_ROOT_HOST='%' --name meumysql mysql/mysql-server:latest

```