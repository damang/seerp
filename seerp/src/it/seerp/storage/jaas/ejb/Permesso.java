package it.seerp.storage.jaas.ejb;

import java.security.Permission;
import java.io.Serializable;
import java.io.File;

/**
 * Classe che modella un permesso di accesso al sistema
 * @author peppe
 */
public class Permesso extends Permission implements Serializable {

    private static final String WILD = "*";
    private static final String SEP_WILD = File.separator + WILD;
    private String _action;
    private String _path;
    private int _id;
    private boolean _bTail = false;

    /**
     *
     * @param id
     * @param name nome del permesso
     * @param action azione eseguibile
     */
    public Permesso(int id,String name, String action) {
        super(name);
        getPath(name);
        _action = action;
        _id=id;
    }
    /**
     *
     * @param name
     * @param action
     */
    public Permesso(String name, String action) {
        super(name);
        getPath(name);
        _action = action;
        _id=-1;
    }

    public boolean implies(Permission permission) {
        if (!(permission instanceof Permesso)) {
            return false;
        }

        Permesso that = (Permesso) permission;

        return (containWith(that._path) && compareAction(that.getActions()));

    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Permesso)) {
            return false;
        }
        Permesso that = (Permesso) obj;
        return (this.getName().equals(that.getName()) &&
                this.compareAction(that.getActions()));
    }

    public int hashCode() {
        return _action.hashCode();
    }

    public String getActions() {
        return _action;
    }

    /**
     * Questo metodo serve per prelevare il path del permesso
     * @param name nome del permesso
     */
    protected void getPath(String name) {
        if (name.endsWith(SEP_WILD) || name.equals(WILD)) {
            _path = name.substring(0, name.length() - 1);
            _bTail = true;
        } else {
            _path = name;
        }
    }

    /**
     * Questo metodo serve per confrontare due action
     * @param action action con cui confrontare
     * @return true il risultato del confronto
     */
    protected boolean compareAction(String action) {
        if (_action.equals(action)) {
            return true;
        }
        return false;

    }

    /**
     *
     * @param path
     * @return
     */
    protected boolean containWith(String path) {
        if (_bTail) {
            return (path.length() >= _path.length()) &&
                    path.startsWith(_path);
        } else {
            return _path.equals(path);
        }
    }
    /**
     *
     * @return
     */
    public int getId() {
        return _id;
    }
}
