<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" />
    <xsl:template match="/">
        <div id="menu">
            <table>
                <tr>
                    <td class="menublock">Hotel Paris</td>
                </tr>
                <tr>
                    <td class="menublock">Hotel London</td>
                </tr>
                <tr>
                    <td id="td3" class="menublock">Hotel Rome</td>
                </tr>
                <tr>
                    <td class="menublock">Hotel New York</td>
                </tr>
                <tr>
                    <td class="menublock">Hotel Montreal</td>
                </tr>
            </table>
            <xsl:call-template name="DynamicSubMenu"></xsl:call-template>
        </div>
    </xsl:template>
    
    <xsl:template name="DynamicSubMenu">
        <div id="submenu" class="submenublock">
            <xsl:for-each select="//Suite">
                <xsl:if test="WeeksFree&gt;0"> <!-- WeeksFree > 0 -->
                    <a href="{Name}.htm">
                        <xsl:value-of select="Name" />
                    </a>
                    <br />
                </xsl:if>
            </xsl:for-each>
        </div>
    </xsl:template>
</xsl:stylesheet>