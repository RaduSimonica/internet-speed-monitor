package ro.crownstudio.internetspeed.pojo;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "Latency")
@Table(name = "latency")
public class Latency {

	@Id
	@SequenceGenerator(name = "latency_sequence", sequenceName = "latency_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "latency_sequence")
	@Column(name = "id", updatable = false)
	private Long id;

	@SerializedName("high")
	@Column(name = "high", updatable = false, nullable = false)
	private Double high;

	@SerializedName("jitter")
	@Column(name = "jitter", updatable = false, nullable = false)
	private Double jitter;

	@SerializedName("iqm")
	@Column(name = "iqm", updatable = false, nullable = false)
	private Double iqm;

	@SerializedName("low")
	@Column(name = "low", updatable = false, nullable = false)
	private Double low;
}