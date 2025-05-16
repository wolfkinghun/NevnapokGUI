package com.example.nevnapok_gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class HelloController {

    @FXML
    ComboBox<String> cbox;
    @FXML
    ListView<String> lsLista;

    public class Adat{
        public String nev;
        public ArrayList<String> honapok;
        public Adat(String sor){
            String[] s = sor.split(";");
            nev = s[0];
            honapok = new ArrayList<>();
            for (int i = 1; i < s.length-1; i++) {
                honapok.add(s[i]);
            }
        }
    }
    ArrayList<Adat> adatok = new ArrayList<>();
    FileChooser  fc = new FileChooser();

    public void initialize(){
        fc.setInitialDirectory(new File("./"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("csv fájlok","*.csv"));
        for (int i = 1; i <= 12; i++) {
            cbox.getItems().add(honev[i]);
        }
        cbox.getSelectionModel().select(0);
    }
    @FXML public void onMegnyitas(){
        File fbe = fc.showOpenDialog(cbox.getScene().getWindow());
        if(fbe!=null){
            Betolt(fbe);
            cbox.setDisable(false);
        }
    }

    public void Betolt(File fajl){
        Scanner be = null;
        try {
            be = new Scanner(fajl,"utf-8");
            be.nextLine();
            while (be.hasNextLine()){
                adatok.add(new Adat(be.nextLine()));
            }
            Szures();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error - file not found");
        }finally {
            if(be!=null)be.close();
        }
    }
    public void Szures(){
        int h = cbox.getSelectionModel().getSelectedIndex();
        if (h != -1) {
            lsLista.getItems().clear();
            String hs = String.format("%02d", h+1);
            TreeMap<String, String> napMap = new TreeMap<>();
            for (Adat nev : adatok) {
                for (String nap : nev.honapok) {
                    if (nap.substring(0,2).equals(hs)) {
                        if (!napMap.containsKey(nap)) napMap.put(nap, nev.nev);
                        else napMap.put(nap, napMap.get(nap) + ", " + nev.nev);
                    }
                }
            }
            for (String nap : napMap.keySet()) lsLista.getItems().add(nap + ":  " + napMap.get(nap));
        }
    }


    String[] honev = { "", "Január", "Február", "Március", "Április", "Május", "Június", "Július", "Augusztus", "Szeptember", "Október", "November", "December" };

    public void Nevjegy(){
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Nevjegy");
        info.setHeaderText(null);
        info.setContentText("Nevjegy \n\tv1 Kando");
        info.showAndWait();
    }

    public void Bezar(){
        Platform.exit();
    }

}