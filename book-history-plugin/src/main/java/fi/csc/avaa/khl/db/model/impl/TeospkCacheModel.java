package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fi.csc.avaa.khl.db.model.Teospk;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Teospk in entity cache.
 *
 * @author CSC
 * @see Teospk
 * @generated
 */
public class TeospkCacheModel implements CacheModel<Teospk>, Externalizable {
    public int teospkid;
    public String teospknimi;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{teospkid=");
        sb.append(teospkid);
        sb.append(", teospknimi=");
        sb.append(teospknimi);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Teospk toEntityModel() {
        TeospkImpl teospkImpl = new TeospkImpl();

        teospkImpl.setTeospkid(teospkid);

        if (teospknimi == null) {
            teospkImpl.setTeospknimi(StringPool.BLANK);
        } else {
            teospkImpl.setTeospknimi(teospknimi);
        }

        teospkImpl.resetOriginalValues();

        return teospkImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        teospkid = objectInput.readInt();
        teospknimi = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(teospkid);

        if (teospknimi == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(teospknimi);
        }
    }
}
