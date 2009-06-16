package it.seerp.Gui.Gestione.agenda;

import java.awt.Color;

/**
 * The EventInstance interface defines how event information will be obtained by
 * the CalendarPanel class. An EventInstance object will contain information
 * about an event on a single occurrence. If an event repeats, there should be a
 * separate EventInstance object for each occurrence.
 * 
 * @see CalendarDataRepository
 * @see CalendarPanel
 * @author Craig Knudsen
 * @version $Id: EventInstance.java,v 1.1 2007/06/11 16:39:18 cknudsen Exp $
 * 
 */
public interface EventInstance extends Comparable {

    /** Get the event title (what appears in the CalendarPanel)
     * @return 
     */
	public abstract String getTitle ();

        /** Get the event description (appears in the mouse-over tooltip)
         * @return 
         */
	public abstract String getDescription ();

        /** Is the event an all-day event?
         * @return 
         */
	public abstract boolean isAllDay ();

        /** Does the event have a time of day specified?
         * @return 
         */
	public abstract boolean hasTime ();

        /** Get the event year (YYYY format)
         * @return 
         */
	public abstract int getYear ();

        /** Get the event month (Jan=1)
         * @return 
         */
	public abstract int getMonth ();

        /** Get the day of the month (1-31)
         * @return 
         */
	public abstract int getDayOfMonth ();

        /** Get hour of event (0-23)
         * @return 
         */
	public abstract int getHour ();

        /** Get minute of event (0-59)
         * @return 
         */
	public abstract int getMinute ();

        /** Get seconds of event (0-59)
         * @return 
         */
	public abstract int getSecond ();

        /** Does the event have a duration?
         * @return 
         */
	public abstract boolean hasDuration ();

        /** Get location of event (can return null if none)
         * @return 
         */
	public abstract String getLocation ();

        /** Get the event duration (in seconds)
         * @return 
         */
	public abstract int getDurationSeconds ();

        /** Get the text color to use for this event
         * @return 
         */
	public Color getForegroundColor ();

        /** Get the background color to use for this event
         * @return 
         */
	public Color getBackgroundColor ();

        /** Get the border color to use for this event
         * @return 
         */
	public Color getBorderColor ();

}
