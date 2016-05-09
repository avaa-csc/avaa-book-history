package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fi.csc.avaa.khl.db.model.BookHistoryAPI;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BookHistoryAPI in entity cache.
 *
 * @author CSC
 * @see BookHistoryAPI
 * @generated
 */
public class BookHistoryAPICacheModel implements CacheModel<BookHistoryAPI>,
    Externalizable {
    public String name;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(3);

        sb.append("{name=");
        sb.append(name);

        return sb.toString();
    }

    @Override
    public BookHistoryAPI toEntityModel() {
        BookHistoryAPIImpl bookHistoryAPIImpl = new BookHistoryAPIImpl();

        if (name == null) {
            bookHistoryAPIImpl.setName(StringPool.BLANK);
        } else {
            bookHistoryAPIImpl.setName(name);
        }

        bookHistoryAPIImpl.resetOriginalValues();

        return bookHistoryAPIImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        name = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }
    }
}
