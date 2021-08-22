package io.instacode.university.department.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Course {
  @Getter(onMethod_ = { @JsonProperty("url") })
  @Setter(onMethod_ = { @JsonProperty("url") })
  private String url;
  @Getter(onMethod_ = { @JsonProperty("department") })
  @Setter(onMethod_ = { @JsonProperty("department") })
  private String department;
  @Getter(onMethod_ = { @JsonProperty("code") })
  @Setter(onMethod_ = { @JsonProperty("code") })
  private String code;
  @Getter(onMethod_ = { @JsonProperty("title") })
  @Setter(onMethod_ = { @JsonProperty("title") })
  private String title;
  @Getter(onMethod_ = { @JsonProperty("description") })
  @Setter(onMethod_ = { @JsonProperty("description") })
  private String description;
  @Getter(onMethod_ = { @JsonProperty("credits") })
  @Setter(onMethod_ = { @JsonProperty("credits") })
  private String credits;
}
