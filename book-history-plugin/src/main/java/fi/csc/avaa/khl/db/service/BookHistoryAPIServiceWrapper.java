package fi.csc.avaa.khl.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BookHistoryAPIService}.
 *
 * @author CSC
 * @see BookHistoryAPIService
 * @generated
 */
public class BookHistoryAPIServiceWrapper implements BookHistoryAPIService,
    ServiceWrapper<BookHistoryAPIService> {
    private BookHistoryAPIService _bookHistoryAPIService;

    public BookHistoryAPIServiceWrapper(
        BookHistoryAPIService bookHistoryAPIService) {
        _bookHistoryAPIService = bookHistoryAPIService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _bookHistoryAPIService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _bookHistoryAPIService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _bookHistoryAPIService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.lang.String getBooksByTitleAuthorFromYearPublisedToYearPublished(
        java.lang.String bookTitle, java.lang.String bookAuthor,
        int fromYearPublished, int toYearPublished) {
        return _bookHistoryAPIService.getBooksByTitleAuthorFromYearPublisedToYearPublished(bookTitle,
            bookAuthor, fromYearPublished, toYearPublished);
    }

    @Override
    public java.lang.String getBooksByTitle(java.lang.String bookTitle) {
        return _bookHistoryAPIService.getBooksByTitle(bookTitle);
    }

    @Override
    public java.lang.String getBooksByAuthor(java.lang.String bookAuthor) {
        return _bookHistoryAPIService.getBooksByAuthor(bookAuthor);
    }

    @Override
    public java.lang.String getBooksByFromYearPublisedToYearPublished(
        int fromYearPublished, int toYearPublished) {
        return _bookHistoryAPIService.getBooksByFromYearPublisedToYearPublished(fromYearPublished,
            toYearPublished);
    }

    @Override
    public java.lang.String getAllBooks() {
        return _bookHistoryAPIService.getAllBooks();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public BookHistoryAPIService getWrappedBookHistoryAPIService() {
        return _bookHistoryAPIService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedBookHistoryAPIService(
        BookHistoryAPIService bookHistoryAPIService) {
        _bookHistoryAPIService = bookHistoryAPIService;
    }

    @Override
    public BookHistoryAPIService getWrappedService() {
        return _bookHistoryAPIService;
    }

    @Override
    public void setWrappedService(BookHistoryAPIService bookHistoryAPIService) {
        _bookHistoryAPIService = bookHistoryAPIService;
    }
}
