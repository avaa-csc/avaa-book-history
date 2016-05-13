package fi.csc.avaa.khl.db.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

import fi.csc.avaa.khl.common.DBTools.*;

/**
 * Provides the remote service interface for BookHistoryAPI. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author CSC
 * @see BookHistoryAPIServiceUtil
 * @see fi.csc.avaa.khl.db.service.base.BookHistoryAPIServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.impl.BookHistoryAPIServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface BookHistoryAPIService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BookHistoryAPIServiceUtil} to access the book history a p i remote service. Add custom service methods to {@link fi.csc.avaa.khl.db.service.impl.BookHistoryAPIServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "getBooksByTitleAuthorPublishedYears")
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> getBooksByTitleAuthorFromYearPublisedToYearPublished(
        java.lang.String bookTitle, java.lang.String bookAuthor,
        int fromYearPublished, int toYearPublished);

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "getBooksByTitle")
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> getBooksByTitle(
        java.lang.String bookTitle);

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "getBooksByAuthor")
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> getBooksByAuthor(
        java.lang.String bookAuthor);

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @com.liferay.portal.kernel.jsonwebservice.JSONWebService(value = "getBooksByPublishedYears")
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<fi.csc.avaa.khl.db.model.Vanhatkirjat> getBooksByFromYearPublisedToYearPublished(
        int fromYearPublished, int toYearPublished);
}
