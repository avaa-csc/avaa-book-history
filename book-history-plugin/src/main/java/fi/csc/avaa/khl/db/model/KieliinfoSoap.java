package fi.csc.avaa.khl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.csc.avaa.khl.db.service.http.KieliinfoServiceSoap}.
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.http.KieliinfoServiceSoap
 * @generated
 */
public class KieliinfoSoap implements Serializable {
    private int _kieliid;
    private String _kieli;

    public KieliinfoSoap() {
    }

    public static KieliinfoSoap toSoapModel(Kieliinfo model) {
        KieliinfoSoap soapModel = new KieliinfoSoap();

        soapModel.setKieliid(model.getKieliid());
        soapModel.setKieli(model.getKieli());

        return soapModel;
    }

    public static KieliinfoSoap[] toSoapModels(Kieliinfo[] models) {
        KieliinfoSoap[] soapModels = new KieliinfoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static KieliinfoSoap[][] toSoapModels(Kieliinfo[][] models) {
        KieliinfoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new KieliinfoSoap[models.length][models[0].length];
        } else {
            soapModels = new KieliinfoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static KieliinfoSoap[] toSoapModels(List<Kieliinfo> models) {
        List<KieliinfoSoap> soapModels = new ArrayList<KieliinfoSoap>(models.size());

        for (Kieliinfo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new KieliinfoSoap[soapModels.size()]);
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
