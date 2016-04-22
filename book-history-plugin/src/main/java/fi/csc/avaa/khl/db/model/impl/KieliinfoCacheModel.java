package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fi.csc.avaa.khl.db.model.Kieliinfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Kieliinfo in entity cache.
 *
 * @author CSC
 * @see Kieliinfo
 * @generated
 */
public class KieliinfoCacheModel implements CacheModel<Kieliinfo>,
    Externalizable {
    public int kieliid;
    public String kieli;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{kieliid=");
        sb.append(kieliid);
        sb.append(", kieli=");
        sb.append(kieli);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Kieliinfo toEntityModel() {
        KieliinfoImpl kieliinfoImpl = new KieliinfoImpl();

        kieliinfoImpl.setKieliid(kieliid);

        if (kieli == null) {
            kieliinfoImpl.setKieli(StringPool.BLANK);
        } else {
            kieliinfoImpl.setKieli(kieli);
        }

        kieliinfoImpl.resetOriginalValues();

        return kieliinfoImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        kieliid = objectInput.readInt();
        kieli = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(kieliid);

        if (kieli == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kieli);
        }
    }
}
