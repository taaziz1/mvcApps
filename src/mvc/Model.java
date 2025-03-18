package mvc;

import java.io.Serializable;

public abstract class Model extends Publisher implements Serializable {
    Boolean unsavedChanges = false;
    String fileName = null;

    public void changed() {
        unsavedChanges = true;
        notifySubscribers();
    }

    public String getFileName() { return fileName; }

    public Boolean getUnsavedChanges() { return unsavedChanges; }

    public void setUnsavedChanges(Boolean unsavedChanges) { this.unsavedChanges = unsavedChanges; }

    public void setFileName(String fileName) { this.fileName = fileName; }

}
