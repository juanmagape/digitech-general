<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <html>
      <body>

        <h1>Llista d’esdeveniments històrics</h1>

        <table border="1">
          <tr>
            <th>Nom</th>
            <th>Data</th>
            <th>Lloc</th>
          </tr>

          <xsl:for-each select="esdeveniments/esdeveniment">
            <tr>
              <td>
                <xsl:value-of select="nom"/>
              </td>
              <td>
                <xsl:value-of select="data"/>
              </td>
              <td>
                <xsl:value-of select="lloc"/>
              </td>
            </tr>
          </xsl:for-each>

        </table>

        <h1>Esdeveniments anteriors a 1900</h1>

        <table border="1">
          <tr>
            <th>Nom</th>
            <th>Data</th>
            <th>Lloc</th>
          </tr>

          <xsl:for-each select="esdeveniments/esdeveniment">
            <xsl:if test="substring(data,1,4) &lt; 1900">
              <tr>
                <td>
                  <xsl:value-of select="nom"/>
                </td>
                <td>
                  <strong>
                    <xsl:value-of select="data"/>
                  </strong>
                </td>
                <td>
                  <xsl:value-of select="lloc"/>
                </td>
              </tr>
            </xsl:if>
          </xsl:for-each>

        </table>

      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
