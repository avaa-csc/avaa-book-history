package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fi.csc.avaa.khl.db.model.Julkaisulajiinfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Julkaisulajiinfo in entity cache.
 *
 * @author CSC
 * @see Julkaisulajiinfo
 * @generated
 */
public class JulkaisulajiinfoCacheModel implements CacheModel<Julkaisulajiinfo>,
    Externalizable {
    public int julklajiid;
    public String julklaji;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{julklajiid=");
        sb.append(julklajiid);
        sb.append(", julklaji=");
        sb.append(julklaji);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Julkaisulajiinfo toEntityModel() {
        JulkaisulajiinfoImpl julkaisulajiinfoImpl = new JulkaisulajiinfoImpl();

        julkaisulajiinfoImpl.setJulklajiid(julklajiid);

        if (julklaji == null) {
            julkaisulajiinfoImpl.setJulklaji(StringPool.BLANK);
        } else {
            julkaisulajiinfoImpl.setJulklaji(julklaji);
        }

        julkaisulajiinfoImpl.resetOriginalValues();

        return julkaisulajiinfoImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        julklajiid = objectInput.readInt();
        julklaji = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(julklajiid);

        if (julklaji == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(julklaji);
        }
    }
}
