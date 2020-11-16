
/**
 * @author Krishna Desai
 */
public interface database {
    String getRecord(int key);

    void addRecord(int key, String record);

    int getSize();
}
