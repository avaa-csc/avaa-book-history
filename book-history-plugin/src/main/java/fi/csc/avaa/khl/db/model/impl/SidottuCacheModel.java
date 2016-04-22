package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fi.csc.avaa.khl.db.model.Sidottu;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Sidottu in entity cache.
 *
 * @author CSC
 * @see Sidottu
 * @generated
 */
public class SidottuCacheModel implements CacheModel<Sidottu>, Externalizable {
    public int sidontaid;
    public String sidonta;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{sidontaid=");
        sb.append(sidontaid);
        sb.append(", sidonta=");
        sb.append(sidonta);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Sidottu toEntityModel() {
        SidottuImpl sidottuImpl = new SidottuImpl();

        sidottuImpl.setSidontaid(sidontaid);

        if (sidonta == null) {
            sidottuImpl.setSidonta(StringPool.BLANK);
        } else {
            sidottuImpl.setSidonta(sidonta);
        }

        sidottuImpl.resetOriginalValues();

        return sidottuImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        sidontaid = objectInput.readInt();
        sidonta = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(sidontaid);

        if (sidonta == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sidonta);
        }
    }
}
