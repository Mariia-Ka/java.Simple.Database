package facade.ofModel;

import controller.big.PublisherInfoDB;
import main.logic.InfoPerson;
import write.read.ConnectToBase;
import write.read.CreateFile;

public class Facade {
    public static void searchInDB (int id) {
        ConnectToBase.getInstance().read(id); // поиск в БД
        PublisherInfoDB.getPublisher().createMessage(ConnectToBase.getInstance().getResultSet());
    }
    public static void searchInFiles (int id) {
        CreateFile.getInstance().read(id); // поиск в файлах
    }
    public static void writeInDataBaseAndInFile (String name, String family, int age) {
        InfoPerson person = new InfoPerson(name, family, age);
        CreateFile.getInstance().write(person);
        ConnectToBase.getInstance().write(person);
        person.showInfo();
    }
    public static void deleteInDataBase(String id) {
        ConnectToBase.getInstance().delete(id);
    }
}
