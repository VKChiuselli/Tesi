/**
 * Article.java
 *
 * robgion
 * www.2clever.it
 * 
 * 20 nov 2016
 * For further information please write to info@2clever.it
 */
package it.clever.nxt.business.model;

/**
 * @author robgion
 *
 */

import java.util.LinkedList;
import java.util.List;

public class Article {

	private String title;
	private String url;
	private List<String> categories;
	private List<String> tags;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public void addCategory(String category){
		if(this.categories == null)
			this.categories = new LinkedList<String>();
		this.categories.add(category);
	}
	public void addTag(String tag){
		if(this.tags == null)
			this.tags = new LinkedList<String>();
		
		this.tags.add(tag);
	}
	@Override
	public String toString() {
		return "Article [title=" + title + ", url=" + url + ", categories="
				+ categories + ", tags=" + tags + "]";
	}
	
	
	
}

