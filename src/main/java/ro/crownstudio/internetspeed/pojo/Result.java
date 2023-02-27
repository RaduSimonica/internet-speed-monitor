package ro.crownstudio.internetspeed.pojo;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "Result")
@Table(name = "result")
public class Result {

	@Id
	@SequenceGenerator(name = "result_sequence", sequenceName = "result_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "result_sequence")
	@Column(name = "id", updatable = false)
	private Long resultId;

	@SerializedName("id")
	@Column(name = "result_id", updatable = false)
	private String id;

	@SerializedName("persisted")
	@Column(name = "persisted", updatable = false, nullable = false)
	private Boolean persisted;

	@SerializedName("url")
	@Column(name = "url", updatable = false, nullable = false)
	private String url;
}