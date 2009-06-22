/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Gestione.agenda;

import java.awt.Color;

/**
 *
 * @author peppe
 */
public class Event implements EventInstance {

        String title, description;
		int Y, M, D, h, m, s,id;
		boolean hasTime, allDay;
		Color fg, bg, border;
		Color[] colors = { Color.blue, Color.red, Color.orange, Color.pink,
		    Color.gray, Color.green, Color.yellow, Color.cyan, Color.magenta };

        /**
         *
         * @param title
         * @param description
         * @param Y
         * @param M
         * @param D
         */
        public Event(String title, String description, int Y, int M, int D, int id) {
			this ( title, description, Y, M, D, 0, 0, 0, false, false, id);
		}

        /**
         *
         * @param title
         * @param description
         * @param Y
         * @param M
         * @param D
         * @param h
         * @param m
         * @param s
         */
        public Event(String title, String description, int Y, int M, int D, int h, int m, int s, int id) {
			this ( title, description, Y, M, D, h, m, s, true, false, id);
		}

        /**
         *
         * @param title
         * @param description
         * @param Y
         * @param M
         * @param D
         * @param h
         * @param m
         * @param s
         * @param hasTime
         * @param allDay
         */
        public Event(String title, String description, int Y, int M, int D, int h, int m, int s, boolean hasTime, boolean allDay, int id) {
			this.title = title;
			this.description = description;
			this.Y = Y;
			this.M = M;
			this.D = D;
			this.h = h;
			this.m = m;
			this.s = s;
			this.hasTime = hasTime;
			this.allDay = allDay;
			// this.fg = new Color ( D * 8 % 256, h * 10 % 256, m * 4 % 256 );
			this.bg = colors[ ( Y + M + D + h + m + s ) % colors.length];
			this.fg = new Color ( this.bg.getRed () / 2, this.bg.getGreen () / 2,
			    this.bg.getBlue () / 2 );
			this.border = this.fg;
            this.id=id;
		}

		public String getTitle () {
			return title;
		}

		public String getDescription () {
			return description;
		}

		public boolean isAllDay () {
			return allDay;
		}

		public boolean hasTime () {
			return hasTime;
		}

		public void setEventoId(int id){
            this.id=id;
        }
         
        public int getYear () {
			return Y;
		}

		public int getMonth () {
			return M;
		}

		public int getDayOfMonth () {
			return D;
		}

		public int getHour () {
			return h;
		}

		public int getMinute () {
			return m;
		}

		public int getSecond () {
			return s;
		}

		public boolean hasDuration () {
			return false;
		}

		public String getLocation ()
		{
			return null;
		}

		public int getDurationSeconds () {
			return 0;
		}

		public Color getForegroundColor () {
			return fg;
		}

		public Color getBackgroundColor () {
			return bg;
		}

		public Color getBorderColor () {
			return border;
		}

		/** Implement the Comparable interface so events can be sorted */
		public int compareTo ( Object o ) {
			EventInstance e2 = (EventInstance) o;
			if ( this.getYear () < e2.getYear () )
				return -1;
			else if ( this.getYear () > e2.getYear () )
				return 1;
			if ( this.getMonth () < e2.getMonth () )
				return -1;
			else if ( this.getMonth () > e2.getMonth () )
				return 1;
			if ( this.getDayOfMonth () < e2.getDayOfMonth () )
				return -1;
			else if ( this.getDayOfMonth () > e2.getDayOfMonth () )
				return 1;
			if ( !this.hasTime && e2.hasTime () )
				return -1;
			else if ( this.hasTime () && !e2.hasTime () )
				return 1;
			else if ( !this.hasTime && !e2.hasTime () )
				return 0;
			if ( this.isAllDay () && !e2.isAllDay () )
				return -1;
			if ( !this.isAllDay () && e2.isAllDay () )
				return 1;
			if ( this.isAllDay () && e2.isAllDay () )
				return 0;
			// both events have a time
			if ( this.getHour () < e2.getHour () )
				return -1;
			else if ( this.getHour () > e2.getHour () )
				return 1;
			if ( this.getMinute () < e2.getMinute () )
				return -1;
			else if ( this.getMinute () > e2.getMinute () )
				return 1;
			if ( this.getSecond () < e2.getSecond () )
				return -1;
			else if ( this.getSecond () > e2.getSecond () )
				return 1;

			return 0;
		}

    @Override
    public Integer getEventoId() {
        return id;
    }
}
