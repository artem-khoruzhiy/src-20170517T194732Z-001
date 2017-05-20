package sample.interfaces.impls;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import sample.object.Smeta;





public class CollectionDataBd implements TableData {

    private ObservableList<Smeta> personList = FXCollections.observableArrayList();

    @Override
    public void add(Smeta smeta) {
        personList.add(smeta);
    }

    @Override
    // для коллекции не используется, но пригодится для случая, когда данные хранятся в БД и пр.
    public void update(Smeta smeta) {
        // т.к. коллекция и является хранилищем - то ничего обновлять не нужно
        // если бы данные хранились в БД или файле - в этом методе нужно было бы обновить соотв. запись
    }

    @Override
    public void delete(Smeta smeta) {
        personList.remove(smeta);
    }

    public ObservableList<Smeta> getPersonList() {
        return personList;
    }

    public void print(){
        int number = 0;
        System.out.println();
        for(Smeta smeta : personList){
            number++;
            System.out.println(number+") fio = "+smeta.getName()+"; phone = "+smeta.getCena());
        }
    }







    public void fillTestData(){
        personList.add(new Smeta("Иван Печкин", "23948723948"));
        personList.add(new Smeta("Роман Романов", "345345345"));
        personList.add(new Smeta("Антон Иванов", "345345345"));
        personList.add(new Smeta("Джон Маклейн", "23423423"));
        personList.add(new Smeta("Джек Воробей", "234234"));
        personList.add(new Smeta("Иван Печкин", "23948723948"));



    }




}
