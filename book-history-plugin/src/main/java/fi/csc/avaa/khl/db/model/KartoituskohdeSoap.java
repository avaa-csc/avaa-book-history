package fi.csc.avaa.khl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.csc.avaa.khl.db.service.http.KartoituskohdeServiceSoap}.
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.http.KartoituskohdeServiceSoap
 * @generated
 */
public class KartoituskohdeSoap implements Serializable {
    private int _kohdeid;
    private String _kartkohde;
    private int _kpl;

    public KartoituskohdeSoap() {
    }

    public static KartoituskohdeSoap toSoapModel(Kartoituskohde model) {
        KartoituskohdeSoap soapModel = new KartoituskohdeSoap();

        soapModel.setKohdeid(model.getKohdeid());
        soapModel.setKartkohde(model.getKartkohde());
        soapModel.setKpl(model.getKpl());

        return soapModel;
    }

    public static KartoituskohdeSoap[] toSoapModels(Kartoituskohde[] models) {
        KartoituskohdeSoap[] soapModels = new KartoituskohdeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static KartoituskohdeSoap[][] toSoapModels(Kartoituskohde[][] models) {
        KartoituskohdeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new KartoituskohdeSoap[models.length][models[0].length];
        } else {
            soapModels = new KartoituskohdeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static KartoituskohdeSoap[] toSoapModels(List<Kartoituskohde> models) {
        List<KartoituskohdeSoap> soapModels = new ArrayList<KartoituskohdeSoap>(models.size());

        for (Kartoituskohde model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new KartoituskohdeSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _kohdeid;
    }

    public void setPrimaryKey(int pk) {
        setKohdeid(pk);
    }

    public int getKohdeid() {
        return _kohdeid;
    }

    public void setKohdeid(int kohdeid) {
        _kohdeid = kohdeid;
    }

    public String getKartkohde() {
        return _kartkohde;
    }

    public void setKartkohde(String kartkohde) {
        _kartkohde = kartkohde;
    }

    public int getKpl() {
        return _kpl;
    }

    public void setKpl(int kpl) {
        _kpl = kpl;
    }
}
