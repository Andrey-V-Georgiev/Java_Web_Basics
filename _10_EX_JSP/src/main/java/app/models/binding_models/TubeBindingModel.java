package app.models.binding_models;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TubeBindingModel {

    private String name;
    private String description;
    private String youtubeLink;
    private String uploader;

    public TubeBindingModel() {
    }

    @NotNull
    @Size(min=2)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(min=2)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Pattern(regexp = "https:\\/\\/www\\.youtube\\.com\\/watch\\?v=.+")
    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    @NotNull
    @Size(min=2)
    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
