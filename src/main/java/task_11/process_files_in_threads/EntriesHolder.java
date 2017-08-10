package task_11.process_files_in_threads;

import java.util.HashMap;

/**
 * Class is designed to store information about duration of time
 * user spend on exact site.
 */
public class EntriesHolder extends HashMap<UserSiteWrapper, Integer> {

    /**
     * Method it designed to update state of {@link EntriesHolder}.
     * When we put value to existing key - new value is added to old one
     *
     * @param key   - the key
     * @param value - time duration
     * @return - new keu value pair
     */
    @Override
    public synchronized Integer put(UserSiteWrapper key, Integer value) {
        if (containsKey(key)) {
            value = value + get(key);
        }
        return super.put(key, value);
    }

}
