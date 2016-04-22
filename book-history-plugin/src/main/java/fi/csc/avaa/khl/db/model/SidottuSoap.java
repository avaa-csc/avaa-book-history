package fi.csc.avaa.khl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.csc.avaa.khl.db.service.http.SidottuServiceSoap}.
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.http.SidottuServiceSoap
 * @generated
 */
public class SidottuSoap implements Serializable {
    private int _sidontaid;
    private String _sidonta;

    public SidottuSoap() {
    }

    public static SidottuSoap toSoapModel(Sidottu model) {
        SidottuSoap soapModel = new SidottuSoap();

        soapModel.setSidontaid(model.getSidontaid());
        soapModel.setSidonta(model.getSidonta());

        return soapModel;
    }

    public static SidottuSoap[] toSoapModels(Sidottu[] models) {
        SidottuSoap[] soapModels = new SidottuSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SidottuSoap[][] toSoapModels(Sidottu[][] models) {
        SidottuSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SidottuSoap[models.length][models[0].length];
        } else {
            soapModels = new SidottuSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SidottuSoap[] toSoapModels(List<Sidottu> models) {
        List<SidottuSoap> soapModels = new ArrayList<SidottuSoap>(models.size());

        for (Sidottu model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SidottuSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _sidontaid;
    }

    public void setPrimaryKey(int pk) {
        setSidontaid(pk);
    }

    public int getSidontaid() {
        return _sidontaid;
    }

    public void setSidontaid(int sidontaid) {
        _sidontaid = sidontaid;
    }

    public String getSidonta() {
        return _sidonta;
    }

    public void setSidonta(String sidonta) {
        _sidonta = sidonta;
    }
}
