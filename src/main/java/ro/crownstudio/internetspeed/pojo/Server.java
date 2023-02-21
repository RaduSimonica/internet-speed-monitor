package ro.crownstudio.internetspeed.pojo;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "Server")
@Table(name = "server")
public class Server {

	@Id
	@SequenceGenerator(name = "server_sequence", sequenceName = "server_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "server_sequence")
	@Column(name = "id", updatable = false)
	private Long serverId;

	@SerializedName("country")
	@Column(name = "country", updatable = false, nullable = false)
	private String country;

	@SerializedName("port")
	@Column(name = "port", updatable = false, nullable = false)
	private Integer port;

	@SerializedName("ip")
	@Column(name = "ip", updatable = false, nullable = false)
	private String ip;

	@SerializedName("host")
	@Column(name = "host", updatable = false, nullable = false)
	private String host;

	@SerializedName("name")
	@Column(name = "name", updatable = false, nullable = false)
	private String name;

	@SerializedName("location")
	@Column(name = "location", updatable = false, nullable = false)
	private String location;

	@SerializedName("id")
	@Column(name = "serverId", updatable = false, nullable = false)
	private Integer id;
}