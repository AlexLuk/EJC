package task_11.process_files_in_threads;

/**
 * Class is designed to wrap information about user name
 * and site name, and then use it as key in {@link EntriesHolder}
 */
public class UserSiteWrapper implements Comparable<UserSiteWrapper> {
    private String userName;
    private String siteName;

    UserSiteWrapper(String userName, String siteName) {
        this.userName = userName;
        this.siteName = siteName;
    }

    String getUserName() {
        return userName;
    }

    String getSiteName() {
        return siteName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserSiteWrapper that = (UserSiteWrapper) o;

        if (!userName.equals(that.userName)) {
            return false;
        }
        return siteName.equals(that.siteName);
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + siteName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return userName + " " + siteName;
    }

    /**
     * Compare two objects
     *
     * @param other - other instance of {@link UserSiteWrapper}
     * @return - result of comparision
     */
    @Override
    public int compareTo(UserSiteWrapper other) {
        int comparation = userName.compareTo(other.userName);
        if (comparation != 0) return comparation;
        return siteName.compareTo(other.siteName);
    }
}
