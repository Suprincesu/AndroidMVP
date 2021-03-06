package com.wahyuadityanugraha.mvpexample.app.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wahyuadityanugraha.mvpexample.app.databases.Repo;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by miftahmubarak on 8/18/14.
 */
@JsonPropertyOrder({
        "profilePic",
        "id",
        "image",
        "timeStamp",
        "status",
        "url",
        "name"
})

@DatabaseTable
public class Feed {

    @DatabaseField
    @JsonProperty("profilePic")
    private String profilePic;

    @DatabaseField(id=true)
    @JsonProperty("id")
    private Integer id;

    @DatabaseField
    @JsonProperty("image")
    private String image;

    @DatabaseField
    @JsonProperty("timeStamp")
    private String timeStamp;

    @DatabaseField
    @JsonProperty("status")
    private String status;

    @DatabaseField
    @JsonProperty("url")
    private String url;

    @DatabaseField
    @JsonProperty("name")
    private String name;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("profilePic")
    public String getProfilePic() {
        return profilePic;
    }

    @JsonProperty("profilePic")
    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("timeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    @JsonProperty("timeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public int save(Repo repo)
    {
        if(repo.feedObject.getByName(name) == null)
        {
            return repo.feedObject.create(this);
        }
        else
        {
            return repo.feedObject.update(this);
        }
    }

    public int delete(Repo repo)
    {
        return repo.feedObject.delete(this);
    }

}