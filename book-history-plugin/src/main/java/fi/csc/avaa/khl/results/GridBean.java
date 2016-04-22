/**
 * 
 */
package fi.csc.avaa.khl.results;


/**
 * @author jmlehtin
 *
 */
public class GridBean {

	private int vkid;
	private String municipality;
	private String author;
	private String title;
	private String publicationYear;
	private String createDate;
	private String modifyDate;
	private String deleteDate;
	
	public GridBean(int vkid, String municipality, String author, String title, String publicationYear) {
		this.vkid = vkid;
		this.municipality = municipality;
		this.author = author;
		this.title = title;
		this.publicationYear = publicationYear;
	}
	
	public GridBean(int vkid, String municipality, String author, String title, String publicationYear, String createDate, String modifyDate, String deleteDate) {
		this.vkid = vkid;
		this.municipality = municipality;
		this.author = author;
		this.title = title;
		this.publicationYear = publicationYear;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.deleteDate = deleteDate;
	}
	
	public int getVkid() {
		return vkid;
	}

	public String getMunicipality() {
		return municipality;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getPublicationYear() {
		return publicationYear;
	}
	
	public String getCreateDate() {
		return createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}
	
	public String getDeleteDate() {
		return deleteDate;
	}

	public enum FieldName {
		VKID("vkid"),
		MUNICIPALITY("municipality"),
		AUTHOR("author"),
		TITLE("title"),
		PUBLICATION_YEAR("publicationYear"),
		CREATE_DATE("createDate"),
		MODIFY_DATE("modifyDate"),
		DELETE_DATE("deleteDate"),
		GENERATED_COLUMN_ACCEPT("accept"),
		GENERATED_COLUMN_UNDELETE("undelete"),
		GENERATED_COLUMN_DELETE_COMPLETELY("deleteCompletely"),
		GENERATED_COLUMN_SET_DELETED("setDeleted"),
		GENERATED_COLUMN_FIELD_CURRENT_VALUE("fieldCurrentValue"),
		GENERATED_COLUMN_FIELD_NEW_VALUE("fieldNewValue");
		
		private String value;
		
		private FieldName(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}
		
		public static FieldName fromValue(String name) {
			if(name == null || name.isEmpty()) {
				return null;
			}
			for(FieldName columnType : FieldName.values()) {
				String col = columnType.getValue();
				if(col.equals(name)) {
					return columnType;
				}
			}
			return null;
		}
	}
	
	public enum PublicGridColumnName {
		MUNICIPALITY("Field.Municipality"),
		AUTHOR("Field.Author"),
		TITLE("Field.Title"),
		PUBLICATION_YEAR("Field.PublicationYear");
		
		String value;
		
		private PublicGridColumnName(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}	
		
		public static PublicGridColumnName getValuefromName(String name) {
			if(name == null || name.isEmpty()) {
				return null;
			}
			for(PublicGridColumnName columnType : PublicGridColumnName.values()) {
				String col = columnType.name();
				if(col.equals(name)) {
					return columnType;
				}
			}
			return null;
		}
	}
	
	public enum AdminAddedModifiedGridColumnName {
		MUNICIPALITY("Field.Municipality"),
		AUTHOR("Field.Author"),
		TITLE("Field.Title"),
		PUBLICATION_YEAR("Field.PublicationYear"),
		CREATE_DATE("Field.CreateDate"),
		MODIFY_DATE("Field.ModifyDate");
		
		String value;
		
		private AdminAddedModifiedGridColumnName(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}	
		
		public static AdminAddedModifiedGridColumnName getValuefromName(String name) {
			if(name == null || name.isEmpty()) {
				return null;
			}
			for(AdminAddedModifiedGridColumnName columnType : AdminAddedModifiedGridColumnName.values()) {
				String col = columnType.name();
				if(col.equals(name)) {
					return columnType;
				}
			}
			return null;
		}
	}
	
	public enum AdminDeletedGridColumnName {
		MUNICIPALITY("Field.Municipality"),
		AUTHOR("Field.Author"),
		TITLE("Field.Title"),
		PUBLICATION_YEAR("Field.PublicationYear"),
		DELETE_DATE("Field.DeleteDate"),
		GENERATED_COLUMN_UNDELETE("Review.Undelete.Undelete"),
		GENERATED_COLUMN_DELETE_COMPLETELY("Review.Delete.Delete");
		
		String value;
		
		private AdminDeletedGridColumnName(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}	
		
		public static AdminDeletedGridColumnName getValuefromName(String name) {
			if(name == null || name.isEmpty()) {
				return null;
			}
			for(AdminDeletedGridColumnName columnType : AdminDeletedGridColumnName.values()) {
				String col = columnType.name();
				if(col.equals(name)) {
					return columnType;
				}
			}
			return null;
		}
	}
	
	public enum AdminAcceptGridColumnName {
		CREATE_DATE("Field.CreateDate"),
		MUNICIPALITY("Field.Municipality"),
		AUTHOR("Field.Author"),
		TITLE("Field.Title"),
		PUBLICATION_YEAR("Field.PublicationYear"),
		GENERATED_COLUMN_ACCEPT("Review.Accept.Accept"),
		GENERATED_COLUMN_DELETE_COMPLETELY("Review.Delete.Delete");
		
		String value;
		
		private AdminAcceptGridColumnName(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}	
		
		public static AdminAcceptGridColumnName getValuefromName(String name) {
			if(name == null || name.isEmpty()) {
				return null;
			}
			for(AdminAcceptGridColumnName columnType : AdminAcceptGridColumnName.values()) {
				String col = columnType.name();
				if(col.equals(name)) {
					return columnType;
				}
			}
			return null;
		}
	}

	public enum AdminModifyGridColumnName {
		MUNICIPALITY("Field.Municipality"),
		AUTHOR("Field.Author"),
		TITLE("Field.Title"),
		PUBLICATION_YEAR("Field.PublicationYear"),
		GENERATED_COLUMN_SET_DELETED("Modify.Delete.Column");
		
		String value;
		
		private AdminModifyGridColumnName(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}	
		
		public static AdminModifyGridColumnName getValuefromName(String name) {
			if(name == null || name.isEmpty()) {
				return null;
			}
			for(AdminModifyGridColumnName columnType : AdminModifyGridColumnName.values()) {
				String col = columnType.name();
				if(col.equals(name)) {
					return columnType;
				}
			}
			return null;
		}
	}

	public enum AdminBatchUpdateGridColumnName {
		MUNICIPALITY("Field.Municipality"),
		AUTHOR("Field.Author"),
		TITLE("Field.Title"),
		PUBLICATION_YEAR("Field.PublicationYear"),
		GENERATED_COLUMN_FIELD_CURRENT_VALUE("BatchUpdate.CurrentValue.Column"),
		GENERATED_COLUMN_FIELD_NEW_VALUE("BatchUpdate.NewValue.Column");
		
		String value;
		
		private AdminBatchUpdateGridColumnName(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}	
		
		public static AdminBatchUpdateGridColumnName getValuefromName(String name) {
			if(name == null || name.isEmpty()) {
				return null;
			}
			for(AdminBatchUpdateGridColumnName columnType : AdminBatchUpdateGridColumnName.values()) {
				String col = columnType.name();
				if(col.equals(name)) {
					return columnType;
				}
			}
			return null;
		}
	}
}
