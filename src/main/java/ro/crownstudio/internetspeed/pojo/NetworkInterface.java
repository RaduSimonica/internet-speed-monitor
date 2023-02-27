package ro.crownstudio.internetspeed.pojo;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "NetworkInterface")
@Table(name = "network_interface")
public class NetworkInterface {

	@Id
	@SequenceGenerator(name = "network_interface_sequence", sequenceName = "network_interface_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "network_interface_sequence")
	@Column(name = "id", updatable = false)
	private Long id;

	@SerializedName("isVpn")
	@Column(name = "is_vpn", updatable = false, nullable = false)
	private Boolean isVpn;

	@SerializedName("name")
	@Column(name = "name", updatable = false, nullable = false)
	private String name;

	@SerializedName("internalIp")
	@Column(name = "internal_ip", updatable = false, nullable = false)
	private String internalIp;

	@SerializedName("externalIp")
	@Column(name = "external_ip", updatable = false, nullable = false)
	private String externalIp;

	@SerializedName("macAddr")
	@Column(name = "mac_addr", updatable = false, nullable = false)
	private String macAddr;
}