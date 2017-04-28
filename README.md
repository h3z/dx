### Setup

1. 在项目根目录执行`mvn clean package`
2. 在项目根目录执行`java -jar target/hzzz-1.0-SNAPSHOT.jar server`启动服务



### API

1. 查询类别下所有商品 `http://localhost:8080/category/{category}`
2. 查询商品所属类别 `http://localhost:8080/commodity/{id}` （只构造了4个数据，id分别1，2，3，4）
3. 为了方便第一个api使用，简单加了一个借口列出所有类别 `http://localhost:8080/allcategories`



### Test

测试只写了单元测试，测根据类别查商品和根据商品查类别。