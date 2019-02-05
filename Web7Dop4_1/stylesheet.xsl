<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
 
	<xsl:template match="/">
		<html>
 
			<head>
				<style type="text/css">
					table.tfmt {
					border: 1px ;
					}
 
					td.colfmt {
					border: 1px ;
					background-color: white;
					color: black;
					text-align:right;
					}
 
					th {
					background-color: #2E9AFE;
					color: white;
					}
 
				</style>
			</head>
 
			<body>
				<table class="tfmt">
					<tr>
						<th style="width:250px">Cost of tariff:</th>
						<th style="width:350px">Cost minute in Net:</th>
						<th style="width:250px">Cost sms:</th>
						<th style="width:250px">Cost megabyte:</th>
						<th style="width:250px">Species:</th>
						<th style="width:250px">Package internet:</th>
						<th style="width:250px">Package minute:</th>
 
 
					</tr>
 
					<xsl:for-each select="tariffs/TariffBonus">
 
						<tr>
							<td class="colfmt">
								<xsl:value-of select="costTariff" />
							</td>
							<td class="colfmt">
								<xsl:value-of select="costMinuteInNet" />
							</td>
 
							<td class="colfmt">
								<xsl:value-of select="costSms" />
							</td>
							<td class="colfmt">
								<xsl:value-of select="costMegabyte" />
							</td>
							<td class="colfmt">
								<xsl:value-of select="species" />
							</td>
							<td class="colfmt">
								<xsl:value-of select="packageInternet" />
							</td>
							<td class="colfmt">
								<xsl:value-of select="packageMinute" />
							</td>
						</tr>
 
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>