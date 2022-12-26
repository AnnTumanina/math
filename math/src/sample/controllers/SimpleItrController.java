package sample.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SimpleItrController {

    private final String regexp = "\\D*\\d+";
    private final String regexp1 = "\\D*\\d+\\.?\\d+";
    @FXML
    public Button result_itr;
    @FXML
    public Label res1;
    @FXML
    public Label res2;
    @FXML
    public Label res3;
    @FXML
    public Label res4;
    @FXML
    private TextField firstNum;
    @FXML
    private TextField secondNum;
    @FXML
    private TextField thirdNum;
    @FXML
    private TextField lastNum;
    @FXML
    private TextField upTXT;
    @FXML
    private TextField downTXT;
    @FXML
    private TextField accuracyTXT;

    private Integer intFromBox(TextField str) {
        return Integer.valueOf(str.getText());
    }
    private Double doubleFromBox(TextField str) {
        return Double.valueOf(str.getText());
    }


    public void getResult() {
        if (firstNum.getText().matches(regexp) && secondNum.getText().matches(regexp) && thirdNum.getText().matches(regexp) && !(Objects.equals(thirdNum.getText(), "0")) && lastNum.getText().matches(regexp) && upTXT.getText().matches(regexp) && downTXT.getText().matches(regexp) && intFromBox(upTXT)>intFromBox(downTXT) && accuracyTXT.getText().matches(regexp1)) {
            List<Double> resultList = calculation(intFromBox(firstNum), intFromBox(secondNum), intFromBox(thirdNum), intFromBox(lastNum), doubleFromBox(upTXT), doubleFromBox(downTXT), doubleFromBox(accuracyTXT));
            if (resultList.get(resultList.size() - 1) == 0) {
                res1.setText("Корней нет");
                res2.setText("");
            } else if (resultList.get(resultList.size() - 1) == 1) {
                res1.setText("Xn = " + resultList.get(resultList.size() - 2).toString());
                res2.setText("Xn-1 = " + resultList.get(resultList.size() - 3).toString());
            } else if (resultList.get(resultList.size() - 1) == 2) {
                res1.setText("(a)Xn = " + resultList.get(resultList.size() - 2).toString());
                res2.setText("(a)Xn-1 = " + resultList.get(resultList.size() - 3).toString());
                res3.setText("(b)Xn = " + resultList.get(resultList.size() - 3).toString());
                res4.setText("(b)Xn-1 = " + resultList.get(resultList.size() - 3).toString());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Введены неверные или не нечисловые значения!", ButtonType.OK);
            alert.showAndWait();
        }


    }


    private static List<Double> calculation(int a, int b, int c, int d, double up, double down, double accuracy) {
        List<Double> resultList = new ArrayList<>();
        int variants = 0;
        double r = 0;
        double result = 0;
        if((a*3*Math.pow(down, 2) + b*2*down + c)<1){
            resultList.add(down);
            do{
                result = ((-(a * Math.pow(down, 3))) - b * down * down - d)/c;
                resultList.add(result);
                down = result;
                r=resultList.get(resultList.size()-1)-resultList.get(resultList.size()-2);
            }
            while (r>accuracy);
            variants = variants + 1;
            resultList.add((double)variants);
        }
        else if((a*3*Math.pow(up, 2) + b*2*up + c)<1){
            resultList.add(up);
            do{
                result = ((-(a * Math.pow(up, 3))) - b * up * up - d)/c;
                resultList.add(result);
                up = result;
                r=Math.abs(resultList.get(resultList.size()-1))-Math.abs(resultList.get(resultList.size()-2));
            }
            while (r>accuracy);
            variants = variants + 1;
            resultList.add((double)variants);
        }
        else{
            resultList.add((double)variants);
        }
        return resultList;
    }
}
