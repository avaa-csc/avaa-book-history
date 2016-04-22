package fi.csc.avaa.khl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.csc.avaa.khl.db.service.http.PuuteServiceSoap}.
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.http.PuuteServiceSoap
 * @generated
 */
public class PuuteSoap implements Serializable {
    private int _puuteid;
    private String _puutenimi;

    public PuuteSoap() {
    }

    public static PuuteSoap toSoapModel(Puute model) {
        PuuteSoap soapModel = new PuuteSoap();

        soapModel.setPuuteid(model.getPuuteid());
        soapModel.setPuutenimi(model.getPuutenimi());

        return soapModel;
    }

    public static PuuteSoap[] toSoapModels(Puute[] models) {
        PuuteSoap[] soapModels = new PuuteSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PuuteSoap[][] toSoapModels(Puute[][] models) {
        PuuteSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PuuteSoap[models.length][models[0].length];
        } else {
            soapModels = new PuuteSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PuuteSoap[] toSoapModels(List<Puute> models) {
        List<PuuteSoap> soapModels = new ArrayList<PuuteSoap>(models.size());

        for (Puute model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PuuteSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _puuteid;
    }

    public void setPrimaryKey(int pk) {
        setPuuteid(pk);
    }

    public int getPuuteid() {
        return _puuteid;
    }

    public void setPuuteid(int puuteid) {
        _puuteid = puuteid;
    }

    public String getPuutenimi() {
        return _puutenimi;
    }

    public void setPuutenimi(String puutenimi) {
        _puutenimi = puutenimi;
    }
}
