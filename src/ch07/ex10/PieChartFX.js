function imports(cls) {
    return Java.type(cls)
}

var Label = imports('javafx.scene.control.Label')
var Font = imports('javafx.scene.text.Font')
var Scene = imports('javafx.scene.Scene')
var Group = imports('javafx.scene.Group')
var ObservableList = imports('javafx.collections.ObservableList')
var FXCollections = imports('javafx.collections.FXCollections')
var PieChart = imports('javafx.scene.chart.PieChart')
var PieChartDataArray = imports('javafx.scene.chart.PieChart.Data[]')
var Files = imports('java.nio.file.Files')
var Paths = imports('java.nio.file.Paths')
var StandardCharsets = imports('java.nio.charset.StandardCharsets')
var Integer = imports('java.lang.Integer')


var list = Files.readAllLines(Paths.get("./importedFruits.txt"), StandardCharsets.UTF_8);
var datas = new PieChartDataArray(list.size())
for (var i = 0; i < list.size(); i++) {
    var words = list.get(i).split(',');
    datas[i] = new PieChart.Data(words[0], new Integer(words[1].trim()));
}
var pieChartData = FXCollections.observableArrayList(datas);
var chart = new PieChart(pieChartData);
chart.title = "Imported Fruits";


var group = new Group();
group.getChildren().add(chart);
$STAGE.scene = new Scene(group);
$STAGE.title = "Imported Fruits";
$STAGE.width = 500;
$STAGE.height = 500;
