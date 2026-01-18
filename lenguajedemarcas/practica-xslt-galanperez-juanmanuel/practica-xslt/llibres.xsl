<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <html>
      <body>
        <h1>Llista de llibres</h1>

        <table border="1">
          <tr>
            <th>Títol</th>
            <th>Autor</th>
            <th>Preu</th>
          </tr>

          <xsl:for-each select="llibres/llibre">
              <tr>
                <td>
                  <xsl:value-of select="titol"/>
                </td>
                <td>
                  <xsl:value-of select="autor"/>
                </td>
                <td>
                    <xsl:value-of select="preu"/>
                </td>
              </tr>
          </xsl:for-each>

        </table>

        <h1>Reptes 1 i 2</h1>

        <table border="1">
          <tr>
            <th>Títol</th>
            <th>Autor</th>
            <th>Preu</th>
          </tr>

          <xsl:for-each select="llibres/llibre">
            <xsl:if test="preu &lt; 40">
              <tr>
                <td>
                  <xsl:value-of select="titol"/>
                </td>
                <td>
                  <xsl:value-of select="autor"/>
                </td>
                <td>
                  <strong>
                    <xsl:value-of select="preu"/>
                  </strong>
                </td>
              </tr>
            </xsl:if>
          </xsl:for-each>

        </table>

      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
