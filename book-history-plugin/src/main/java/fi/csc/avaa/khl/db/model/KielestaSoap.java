package fi.csc.avaa.khl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.csc.avaa.khl.db.service.http.KielestaServiceSoap}.
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.http.KielestaServiceSoap
 * @generated
 */
public class KielestaSoap implements Serializable {
    private int _kieliid;
    private String _kieli;

    public KielestaSoap() {
    }

    public static KielestaSoap toSoapModel(Kielesta model) {
        KielestaSoap soapModel = new KielestaSoap();

        soapModel.setKieliid(model.getKieliid());
        soapModel.setKieli(model.getKieli());

        return soapModel;
    }

    public static KielestaSoap[] toSoapModels(Kielesta[] models) {
        KielestaSoap[] soapModels = new KielestaSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static KielestaSoap[][] toSoapModels(Kielesta[][] models) {
        KielestaSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new KielestaSoap[models.length][models[0].length];
        } else {
            soapModels = new KielestaSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static KielestaSoap[] toSoapModels(List<Kielesta> models) {
        List<KielestaSoap> soapModels = new ArrayList<KielestaSoap>(models.size());

        for (Kielesta model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new KielestaSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _kieliid;
    }

    public void setPrimaryKey(int pk) {
        setKieliid(pk);
    }

    public int getKieliid() {
        return _kieliid;
    }

    public void setKieliid(int kieliid) {
        _kieliid = kieliid;
    }

    public String getKieli() {
        return _kieli;
    }

    public void setKieli(String kieli) {
        _kieli = kieli;
    }
}
