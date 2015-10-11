var http = require('http'),
    express = require('express'),
    app = express(),
    sqlite3 = require('sqlite3').verbose(),
    bodyParser = require('body-parser'),
    db = new sqlite3.Database('phonebook.db');

// Использовать Jade для рендера темплейтов
app.use(express.static('public'));
app.set('views', __dirname + '/public');
app.engine('.html', require('jade').__express);

// Разрешить Express js получить данные из POSt запроса
app.use(bodyParser.urlencoded({
    extended: true
}));
app.use(bodyParser.json());

// Инициализацияя БД SQLITE3
db.get("SELECT name FROM sqlite_master WHERE type='table' AND name='phonebook'", function(err, row) {
    if(err !== null) {
        console.log(err);
    }
    else if(row == null) {
        db.run('CREATE TABLE "phonebook" ("id" INTEGER PRIMARY KEY AUTOINCREMENT, "name" VARCHAR(255), "homephone" VARCHAR(255), "phonenum" VARCHAR(255))', function(err) {
            if(err !== null) {
                console.log(err);
            }
            else {
                console.log("SQL Table 'phonebook' initialized.");
            }
        });
    }
    else {
        console.log("SQL Table 'phonebook' already initialized.");
    }
});

// Рендер index.jade используя данные БД
app.get('/', function(req, res) {

    db.all('SELECT * FROM phonebook ORDER BY name', function(err, row) {
        if(err !== null) {
            res.status(500).send("Произошла ошибка -- " + err);
        }
        else {
            res.render('index.jade', {phonebook: row}, function(err, html) {
                res.status(200).send(html);
            });
        }
    });
});

// route который будет обрабатывать создание новой записи
app.post('/add', function(req, res) {
    name = req.body.name;
    homephone = req.body.homephone;
    phonenum = req.body.phonenum;
    sqlRequest = "INSERT INTO 'phonebook' (name, homephone, phonenum) VALUES('" + name + "', '" + homephone + "', '" + phonenum + "')"
    db.run(sqlRequest, function(err) {
        if(err !== null) {
            res.status(500).send("An error has occurred -- " + err);
        }
        else {
            res.redirect('back');
        }
    });
});

//route который будет обрабатывать удаление новой записи
app.get('/delete/:id', function(req, res) {
    db.run("DELETE FROM phonebook WHERE id='" + req.params.id + "'", function(err) {
        if(err !== null) {
            res.status(500).send("An error has occurred -- " + err);
        }
        else {
            res.redirect('back');
        }
    });
});

app.get('/edit/:id', function(req, res) {
    EDname = req.query.EDname;
    EDhomephone = req.query.EDhomephone;
    EDphonenum = req.query.EDphonenum;
    id=req.params.id;
        console.log("%s",id);
    sqlRequest = "UPDATE 'phonebook' SET name='"+ EDname + "', homephone='" + EDhomephone + "', phonenum='" + EDphonenum + "' WHERE id='" +id + "'";
    db.run(sqlRequest, function(err) {
        if(err !== null) {
            res.status(500).send("An error has occurred -- " + err);
        }
        else {
            res.redirect('back');
        }
    });
});

var port = process.env.PORT || 9250;
var host = process.env.HOST || "127.0.0.1";


var server = http.createServer(app).listen(port, host, function() {
    console.log("Сервер стартанул на %s:%d",
                host, port);
});
