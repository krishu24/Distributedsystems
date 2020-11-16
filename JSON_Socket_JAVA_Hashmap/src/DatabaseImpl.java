import java.util.HashMap;

/**
 * @author Krishna Desai
 */
public class DatabaseImpl implements database {

    private HashMap<Integer, String> mydb;

    public DatabaseImpl() {
        this.mydb = new HashMap<>();
    }

    @Override
    public String getRecord(int key) {
        return this.mydb.get(key);
    }

    @Override
    public void addRecord(int key, String record) {
        this.mydb.put(key, record);
    }

    @Override
    public int getSize() {
        return this.mydb.size();
    }
}
