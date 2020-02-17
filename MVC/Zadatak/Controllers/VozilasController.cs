using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Zadatak.Models.Database;

namespace Zadatak.Controllers
{
    public class VozilasController : Controller
    {
        private PPPKEntities5 db = new PPPKEntities5();

        // GET: Vozilas
        public ActionResult Index()
        {
            return View(db.Vozilas.ToList());
        }

        // GET: Vozilas/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Vozila vozila = db.Vozilas.Find(id);
            ViewBag.Servisi = db.GetServisi().Where(servis => servis.VoziloID == id).OrderByDescending(servis => servis.Datum);

            if (vozila == null)
            {
                return HttpNotFound();
            }
            return View(vozila);
        }

        // GET: Vozilas/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Vozilas/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "IDVozilo,Tip,Marka,StanjeKilometra,GodinaProizvodnje")] Vozila vozila)
        {
            if (ModelState.IsValid)
            {
                db.Vozilas.Add(vozila);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(vozila);
        }

        // GET: Vozilas/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Vozila vozila = db.Vozilas.Find(id);
            if (vozila == null)
            {
                return HttpNotFound();
            }
            return View(vozila);
        }

        // POST: Vozilas/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "IDVozilo,Tip,Marka,StanjeKilometra,GodinaProizvodnje")] Vozila vozila)
        {
            if (ModelState.IsValid)
            {
                db.Entry(vozila).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(vozila);
        }

        // GET: Vozilas/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Vozila vozila = db.Vozilas.Find(id);
            if (vozila == null)
            {
                return HttpNotFound();
            }
            return View(vozila);
        }

        // POST: Vozilas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Vozila vozila = db.Vozilas.Find(id);
            db.Vozilas.Remove(vozila);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
