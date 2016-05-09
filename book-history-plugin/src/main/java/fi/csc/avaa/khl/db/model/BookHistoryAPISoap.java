package fi.csc.avaa.khl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.csc.avaa.khl.db.service.http.BookHistoryAPIServiceSoap}.
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.http.BookHistoryAPIServiceSoap
 * @generated
 */
public class BookHistoryAPISoap implements Serializable {
    private String _name;

    public BookHistoryAPISoap() {
    }

    public static BookHistoryAPISoap toSoapModel(BookHistoryAPI model) {
        BookHistoryAPISoap soapModel = new BookHistoryAPISoap();

        soapModel.setName(model.getName());

        return soapModel;
    }

    public static BookHistoryAPISoap[] toSoapModels(BookHistoryAPI[] models) {
        BookHistoryAPISoap[] soapModels = new BookHistoryAPISoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static BookHistoryAPISoap[][] toSoapModels(BookHistoryAPI[][] models) {
        BookHistoryAPISoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new BookHistoryAPISoap[models.length][models[0].length];
        } else {
            soapModels = new BookHistoryAPISoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static BookHistoryAPISoap[] toSoapModels(List<BookHistoryAPI> models) {
        List<BookHistoryAPISoap> soapModels = new ArrayList<BookHistoryAPISoap>(models.size());

        for (BookHistoryAPI model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new BookHistoryAPISoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _name;
    }

    public void setPrimaryKey(String pk) {
        setName(pk);
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}
