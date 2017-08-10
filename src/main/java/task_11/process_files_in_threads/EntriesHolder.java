package task_11.process_files_in_threads;

import java.util.HashMap;

public class EntriesHolder extends HashMap<UserSiteWrapper, Integer>{

    @Override
    public synchronized Integer put(UserSiteWrapper key, Integer value) {
        if(containsKey(key)){
            value = value + get(key);
        }
        return super.put(key, value);
    }

}
