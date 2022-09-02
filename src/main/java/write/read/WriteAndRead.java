package write.read;

import main.logic.InfoPerson;

public interface WriteAndRead { // шаблон FactoryMethod
    void write (InfoPerson obj);
    void read(int id);
}
