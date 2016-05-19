package fi.csc.avaa.khl.db.service.impl;

import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.security.ac.AccessControlled;
import fi.csc.avaa.khl.db.model.Vanhatkirjat;
import fi.csc.avaa.khl.db.model.impl.VanhatkirjatImpl;
import fi.csc.avaa.khl.db.service.base.BookHistoryAPIServiceBaseImpl;
import fi.csc.avaa.tools.logging.AvaaLogger;

import java.util.List;

import static fi.csc.avaa.khl.db.service.VanhatkirjatLocalServiceUtil.*;
import static fi.csc.avaa.khl.db.service.VanhatkirjatLocalServiceUtil.findAllByAuthor;
import static fi.csc.avaa.khl.db.service.VanhatkirjatLocalServiceUtil.findAllByTitle;
import static fi.csc.avaa.khl.validator.APIQueryValidator.validateFromYearPublisedToYearPublished;
import static fi.csc.avaa.khl.validator.APIQueryValidator.validateTitleAuthorFromYearPublisedToYearPublished;
import static fi.csc.avaa.khl.validator.BaseValidator.validateStringForSQLQuery;

/**
 * The implementation of the book history a p i remote service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link fi.csc.avaa.khl.db.service.BookHistoryAPIService} interface.
 * <p>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated
 * JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.base.BookHistoryAPIServiceBaseImpl
 * @see fi.csc.avaa.khl.db.service.BookHistoryAPIServiceUtil
 */
@JSONWebService("bookHistoryAPI")
public class BookHistoryAPIServiceImpl extends BookHistoryAPIServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use 
     * {@link fi.csc.avaa.khl.db.service.BookHistoryAPIServiceUtil} to access the book history a p i remote service.
     */

	static final AvaaLogger log = new AvaaLogger(BookHistoryAPIServiceImpl.class.getName());

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "getBooksByTitleAuthorPublishedYears")
	public String getBooksByTitleAuthorFromYearPublisedToYearPublished(String bookTitle, String bookAuthor, int
			fromYearPublished, int toYearPublished) {

		if (validateTitleAuthorFromYearPublisedToYearPublished(bookTitle, bookAuthor, fromYearPublished,
				toYearPublished)) {
			List result = null;

			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(VanhatkirjatImpl.class, PortletClassLoaderUtil
						.getClassLoader());
				query.add(PropertyFactoryUtil.forName("teoknimi").eq(bookTitle));
				query.add(PropertyFactoryUtil.forName("tekija").eq(bookAuthor));
				query.add(PropertyFactoryUtil.forName("painovuosi").between(fromYearPublished, toYearPublished));

				result = dynamicQuery(query);
			} catch (SystemException e) {
				log.error("Unable to fetch vanhatkirjat entry from database with title: " + bookTitle + " and " +
						"author:" +
						" " +
						bookAuthor + " period: from year: " + fromYearPublished + " to year: " + toYearPublished);
				e.printStackTrace();
			}
			return new Gson().toJson(result);
		}
		return "no results";
	}

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "getBooksByTitle")
	public String getBooksByTitle(String bookTitle) {
		if (validateStringForSQLQuery(bookTitle)) {
			List result = null;

			try {
				result = findAllByTitle(bookTitle);
			} catch (SystemException e) {
				log.error("Unable to fetch vanhatkirjat entry from database with title: " + bookTitle);
				e.printStackTrace();
			}
			return new Gson().toJson(result);
		}
		return "no results";
	}

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "getBooksByAuthor")
	public String getBooksByAuthor(String bookAuthor) {
		if (validateStringForSQLQuery(bookAuthor)) {
			List result = null;

			try {
				result = findAllByAuthor(bookAuthor);
			} catch (SystemException e) {
				log.error("Unable to fetch vanhatkirjat entry from database with author: " + bookAuthor);
				e.printStackTrace();
			}
			return new Gson().toJson(result);
		}
		return "no results";
	}

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "getBooksByPublishedYears")
	public String getBooksByFromYearPublisedToYearPublished(int fromYearPublished, int toYearPublished) {
		if (validateFromYearPublisedToYearPublished(fromYearPublished, toYearPublished)) {
			List result = null;

			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(VanhatkirjatImpl.class, PortletClassLoaderUtil
						.getClassLoader());
				query.add(PropertyFactoryUtil.forName("painovuosi").between(fromYearPublished, toYearPublished));

				result = dynamicQuery(query);
			} catch (SystemException e) {
				log.error("Unable to fetch vanhatkirjat entry from database for period: from year: " +
						fromYearPublished +
						" to year: " + toYearPublished);
				e.printStackTrace();
			}
			return new Gson().toJson(result);
		}
		return "no results";
	}

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "getAllBooks")
	public String getAllBooks() {
		try {
			return new Gson().toJson(getVanhatkirjats(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
		} catch (SystemException e) {
			log.error("Error fetching all Vanhatkirjat objects");
			e.printStackTrace();
		}
		return null;
	}
}
