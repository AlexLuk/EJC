package task_11.process_files_in_threads;

public class UserSiteWrapper implements Comparable<UserSiteWrapper> {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public String getSiteName() {
        return siteName;
    }

    private String siteName;

    public UserSiteWrapper(String userName, String siteName) {
        this.userName = userName;
        this.siteName = siteName;
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
        return userName+" "+siteName;
    }

    @Override
    public int compareTo(UserSiteWrapper other) {
        int comparation = userName.compareTo(other.userName);
        if(comparation != 0) return comparation;
        return siteName.compareTo(other.siteName);
    }
}